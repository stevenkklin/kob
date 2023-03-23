// import axios from "axios";

export default {
    state: {
        status: "matching", // matching表示匹配界面， playing表示对战界面
        socket: null,
        opponent_username: "",
        opponent_photo: "",
    },
    getters: {},
    mutations: {
        updateSocket(state, socket) {
            state.socket = socket;
        },
        updateOppoent(state, oppoent) {
            state.opponent_username = oppoent.username;
            state.opponent_photo = oppoent.photo;
        },
        updateStatus(state, status) {
            state.status = status;
        }
    },
    actions: {},
    modules: {}
}