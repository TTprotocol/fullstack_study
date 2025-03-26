<template>
    <div id="option">
        <h2>{{ selectedDrink.name }} 옵션 선택</h2>
        사이즈 :
        <br />
        <label>
            <input
                type="radio"
                name="size"
                value="Small"
                v-model="options.size"
                @click="$emit('options-changed', options)"
            />
            Small
        </label>
        <label>
            <input
                type="radio"
                name="size"
                value="Medium"
                v-model="options.size"
                @click="$emit('options-changed', options)"
            />
            Medium
        </label>
        <label>
            <input
                type="radio"
                name="size"
                value="Large"
                v-model="options.size"
                @click="$emit('options-changed', options)"
            />
            Large
        </label>
        <br />
        <br />
        <label>
            <input
                type="checkbox"
                :true-value="'추가함'"
                :false-value="'없음'"
                v-model="options.extraShot"
                @click="$emit('options-changed', options)"
            />
            샷 추가
        </label>

        <br />
        <br />
        얼음 양 :
        <select
            :value="options.ice"
            v-model="options.ice"
            @chaged="$emit('options-changed', options)"
        >
            <option value="적게">적게</option>
            <option value="보통">보통</option>
            <option value="많이">많이</option>
        </select>
        <br />
        <br />
    </div>
</template>

<style>
#option {
    background-color: lightblue;
    padding: 5px;
}
</style>

<script>
export default {
    name: 'DrinkOptions',
    props: ['selectedDrink'],
    emits: ['options-changed'],
    data() {
        return {
            options: {
                size: 'Medium',
                extraShot: false,
                ice: '보통',
            },
        };
    },
    methods: {},
};
</script>
