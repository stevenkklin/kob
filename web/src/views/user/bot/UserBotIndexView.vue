<template>
  <ContentField>
    我的Bot
  </ContentField>
</template>

<script>
import ContentField from '../../../components/ContentField.vue';
import axios from "axios";
import {useStore} from "vuex";

export default {
  components: {
    ContentField
  },
  setup() {

    const store = useStore();

    axios.get('http://localhost:3000/user/bot/getList/', {
      headers: {
        Authorization: "Bearer " + store.state.user.token,
      }
    })
        .then(res => {
          console.log(res)
        })
        .catch((res) => {
          console.log(res)
        })
        .then(() => {
          console.log("getUserListBot")
        });

    // axios.post('http://localhost:3000/user/bot/update/', {
    //   botId: 5,
    //   title: "Bot的标题5",
    //   description: "Bot的描述5",
    //   content: "Bot的代码5",
    // }, {
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   }
    // })
    //     .then(res => {
    //       console.log(res)
    //     })
    //     .catch((res) => {
    //       console.log(res)
    //     })
    //     .then(() => {
    //       console.log("updateBot")
    //     });

    // axios.post('http://localhost:3000/user/bot/add/', {
    //   title: "Bot的标题",
    //   description: "Bot的描述",
    //   content: "Bot的代码",
    // }, {
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   }
    // })
    //     .then(res => {
    //       console.log(res)
    //     })
    //     .catch((res) => {
    //       console.log(res)
    //     })
    //     .then(() => {
    //       console.log("addBot")
    //     });


    // axios.post('http://localhost:3000/user/bot/remove/', {
    //   botId: 2
    // }, {
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   }
    // })
    //     .then(res => {
    //       console.log(res)
    //     })
    //     .catch((res) => {
    //       console.log(res)
    //     })
    //     .then(() => {
    //       console.log("removeBot")
    //     });
  }
}

</script>

<style scoped></style>