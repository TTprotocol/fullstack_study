<template>
    <!-- <div>
        <h2>App 컴포넌트</h2>
        <hr />
        <ul>
            <CheckboxItem
                v-for="idol in idols"
                :key="idol.id"
                :name="idol.name"
                :checked="idol.checked"
            />
        </ul>
        <InputName @nameChanged="nameChangeHandler" />
        <br />
        <h3>App 데이터 : {{ parentName }}</h3>
    </div> -->

    <!-- mission1_MenuList -->
    <div id="total">
        <h1>카페 주문 앱</h1>
        <h2>메뉴 선택</h2>
        <MenuList :menuList="menuList" @select-drink="clickHandler" />
        <h2 id="selected" v-show="selectedDrink.name !== ''">
            선택된 메뉴 : {{ selectedDrink.name }}
        </h2>
        <DrinkOptions
            v-show="selectedDrink.name !== ''"
            :selectedDrink="selectedDrink"
            @options-changed="selectOptions"
        />
        <div id="nowOptions" v-show="selectedDrink.name !== ''">
            <h3>현재 선택 옵션</h3>
            <p>사이즈 : {{ options.size }}</p>
            <p>추가샷 : {{ options.extraShot }}</p>
            <p>얼음 양 : {{ options.ice }}</p>
            <br />
        </div>
        <OrderSummary
            v-show="selectedDrink.name !== ''"
            :drink="selectedDrink"
            :optionData="options"
            @place-order="placeOrder"
        />
        <OrderHistory v-if="orders.length > 0" :orders="orders" />
        <p v-else="orders">주문 내역이 없습니다.</p>

        <button class="btn btn-primary" @click="statisticClilck">
            {{ show ? '통계 숨기기' : '통계 보기' }}
        </button>
        <Statistics v-show="show" :orders="orders" />
    </div>
</template>

<style>
#total {
    background-color: #fff;
    color: black;
    padding: 20px;
}
#selected {
    /* display: inline-block; */
    height: 50px;
    background-color: lightgray;
    /* text-align: center; */
    line-height: 50px;
}

#nowOptions {
    background-color: lightgray;
    margin-top: 15px;
    padding: 5px;
}

#nowOptions p {
    margin: 5px;
}
</style>

<script>
// 현재 위치에서 components의 CheckboxItem.vue를 가져온다.
import CheckboxItem from './components/CheckboxItem.vue';
import InputName from './components/InputName.vue';
import MenuList from './components/mission1_MenuList.vue';
import DrinkOptions from './components/mission2_DrinkOptions.vue';
import OrderSummary from './components/mission3_OrderSummary.vue';
import OrderHistory from './components/mission4_OrderHistory.vue';
import Statistics from './components/mission5_Statistics.vue';

export default {
    name: 'App',
    components: {
        // CheckboxItem,
        // InputName,
        MenuList,
        DrinkOptions,
        OrderSummary,
        OrderHistory,
        Statistics,
    },
    data() {
        return {
            // idols: [
            //     { id: 1, name: 'BTS', checked: true },
            //     { id: 2, name: 'Black', checked: false },
            //     { id: 3, name: 'EXO', checked: true },
            //     { id: 4, name: 'ITZY', checked: false },
            // ],
            // parentName: '',
            menuList: [
                { name: '아메리카노', price: 4000 },
                { name: '카페라떼', price: 4500 },
                { name: '바닐라라떼', price: 4800 },
                { name: '콜드브루', price: 5000 },
            ],
            selectedDrink: { name: '', price: 0 },
            options: {
                size: 'Medium',
                extraShot: '없음',
                ice: '보통',
            },
            orders: [],
            show: false,
        };
    },
    methods: {
        // nameChangeHandler(e) {
        //     this.parentName = e.name;
        // },
        clickHandler(e) {
            this.selectedDrink = e;
        },
        selectOptions(e) {
            this.options = e;
        },
        placeOrder(e) {
            alert(`${this.selectedDrink.name} 주문이 완료되었습니다!`);
            this.orders.unshift(e);
        },
        statisticClilck() {
            this.show = !this.show;
        },
    },
};
</script>
