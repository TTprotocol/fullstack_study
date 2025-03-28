<template>
    <div>
        <Calc />
        <br />
        <hr />
        <br />
        <Calc2 />
        <br />
        <hr />
        <br />
        <Calc3 />
        <br />
        <hr />
        <br />
        <Calc4 />
        <br />
        <hr />
        <br />
        <Calc5 />
        <br />
        <hr />
        <br />
        <Calc6 />
        <br />
        <hr />
        <br />
        <Calc8 />
    </div>
</template>
<script>
import Calc from './components/Calc.vue';
import Calc2 from './components/Calc2.vue';
import Calc3 from './components/Calc3.vue';
import Calc4 from './components/Calc4.vue';
import Calc5 from './components/Calc5.vue';
import Calc6 from './components/Calc6.vue';
import Calc8 from './components/Calc8.vue';

export default {
    name: 'App',
    components: {
        Calc,
        Calc2,
        Calc3,
        Calc4,
        Calc5,
        Calc6,
        Calc8,
    },
};
</script>
