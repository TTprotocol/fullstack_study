package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

// DB 연결 설정을 위한 Spring 설정 클래스
// application.properties 파일로부터 DB 정보를 불러옴
// HikariCP를 사용한 커넥션 풀(DataSource) 설정 포함
@Log4j2
@Configuration
@PropertySource({"classpath:/application.properties"})  // 설정 파일 위치 설정
@MapperScan(basePackages = {"org.scoula.board.mapper", "org.scoula.member.mapper", "org.scoula.travel.mapper"})
@ComponentScan(basePackages = {"org.scoula.board.service", "org.scoula.member.service", "org.scoula.travel.service"})
@EnableTransactionManagement    // 트랜잭션 어노테이션 활성화
public class RootConfig {
    // DB 설정
    // application.properties에서 값 주입
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        
        // MyBatis 설정 파일(xml) 위치 지정
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        
        // 커넥션 풀 설정 주입
        sqlSessionFactory.setDataSource(dataSource());

        // 실제 SqlSessionFactory 객체 반환
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    // 트랜잭션 매니저 등록
    // 스프링에서 @Transaction 사용을 가능하게 함.
    @Bean
    public DataSourceTransactionManager transactionManager() {
        // DataSource
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }
}
