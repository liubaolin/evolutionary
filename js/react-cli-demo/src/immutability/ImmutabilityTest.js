import update from 'immutability-helper';
import produce from 'immer';

//如果操作不可变数据

const state = {filter: 'completed', todos: ['Learn React']};

//原生写法
//通过延展属性
const newState = {...state, todos: [...state.todos, 'Learn Redux']}
//Es6写法  性能最高的写法
const newState2 = Object.assign({}, state, {todos: [...state.todos, 'Learn Redux']});

//复杂场景，比如对象层级比较深
const newState3 = update(state, {todos: {$push: ['Learn Redux']}});

//immer 需要为每个属性做代理，性能稍差，适用与简单场景，属性较多或层级较深时慎用
const newState4 = produce(state, draftState => {
    draftState.todos.push('Learn Redux');
})