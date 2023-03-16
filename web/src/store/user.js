import axios from "axios";

export default {
    state: {
        id: "",
        username: "",
        photo: "",
        token: "",
        is_login: false,
    },
    getters: {},
    mutations: {
        updateUser(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.photo = user.photo;
            state.is_login = user.is_login;
        },
        updateToken(state, token) {
            state.token = token;
        },
        logout(state) {
            state.id = "";
            state.username = "";
            state.photo = "";
            state.token = "";
            state.is_login = false;
        }
    },
    actions: {
        login(context, data) {
            // 获取token
            axios.post('http://localhost:3000/user/account/token/', {
                username: data.username,
                password: data.password,
            })
                .then(res => {
                    if (res.data.code === 200) {
                        context.commit("updateToken", res.data.token);
                        console.log(res.data.token)
                        data.success(res);
                    } else {
                        data.error(res);
                    }
                })
                .catch(res => {
                    data.error(res);
                })
                .then(() => {

                    console.log("getToken")
                });
        },
        getinfo(context, data) {
            // getInfo by token
            axios.get('http://localhost:3000/user/account/info/', {
                headers: {
                    Authorization: "Bearer " + context.state.token,
                }
            })
                .then(res => {
                    if (res.data.code === 200) {
                        context.commit("updateUser", {
                            ...res.data,

                            is_login: true,
                        });
                        data.success(res);
                    } else {
                        data.error(res);
                    }
                })
                .catch(res => {
                    data.error(res);
                })
                .then(() => {

                    console.log("getInfoByToken")
                });
        },
        logout(context) {
            context.commit("logout");
        }
    },
    modules: {}
}