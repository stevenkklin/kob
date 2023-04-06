<template>
  <div class="container">
    <div class="row">
      <div class="col-3">
        <div class="card" style="margin-top: 20px">
          <div class="card-body">
            <img :src="$store.state.user.photo" alt="" style="width: 100%;">
          </div>
        </div>
      </div>
      <div class="col-9">
        <div class="card" style="margin-top: 20px">
          <div class="card-header">
              <span style="font-size: 130%">
                我的Bot
              </span>
            <button type="button" class="btn btn-primary float-end" data-bs-toggle="modal"
                    data-bs-target="#add-bot-btn">
              创建Bot
            </button>

            <!-- Modal -->
            <div class="modal fade" id="add-bot-btn" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
              <div class="modal-dialog modal-xl">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">创建Bot</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <div class="mb-3">
                      <label for="add-bot-title" class="form-label">名称</label>
                      <input v-model="botadd.title" type="text" class="form-control" id="add-bot-title"
                             placeholder="请输入Bot名称">
                    </div>
                    <div class="mb-3">
                      <label for="add-bot-description" class="form-label">简介</label>
                      <textarea v-model="botadd.description" class="form-control" id="add-bot-description" rows="3"
                                placeholder="请输入Bot简介"></textarea>
                    </div>
                    <div class="mb-3">
                      <label for="add-bot-code" class="form-label">代码</label>
                      <VAceEditor v-model:value="botadd.content" @init="editorInit" lang="c_cpp"
                                  :theme="aceConfig.theme" style="height: 300px"
                                  :options="aceConfig.options" class="ace-editor" />
                    </div>
                  </div>
                  <div class="modal-footer">
                    <div class="error_message">{{ botadd.msg }}</div>
                    <button type="button" class="btn btn-primary" @click="add_bot">创建</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="refresh_bots">取消</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="card-body">
            <table class="table table-hover">
              <thead>
              <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="bot in bots" :key="bot.id">
                <td>{{ bot.title }}</td>
                <td>{{ bot.createTime }}</td>
                <td>
                  <button type="button" class="btn btn-secondary" style="margin-right: 10px;" data-bs-toggle="modal"
                          :data-bs-target="'#update-bot-modal-' + bot.id">修改</button>
                  <!-- Modal -->
                  <div class="modal fade" :id="'update-bot-modal-' + bot.id" tabindex="-1" aria-labelledby="exampleModalLabel"
                       aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h1 class="modal-title fs-5" id="exampleModalLabel">修改Bot</h1>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                          <div class="mb-3">
                            <label for="add-bot-title" class="form-label">名称</label>
                            <input v-model="bot.title" type="text" class="form-control" id="add-bot-title"
                                   placeholder="请输入Bot名称">
                          </div>
                          <div class="mb-3">
                            <label for="add-bot-description" class="form-label">简介</label>
                            <textarea v-model="bot.description" class="form-control" id="add-bot-description" rows="3"
                                      placeholder="请输入Bot简介"></textarea>
                          </div>
                          <div class="mb-3">
                            <label for="add-bot-code" class="form-label">代码</label>
                            <VAceEditor v-model:value="bot.content"
                                        @init="editorInit" lang="c_cpp"
                                        :theme="aceConfig.theme" style="height: 300px"
                                        :options="aceConfig.options" class="ace-editor" />
                          </div>
                        </div>
                        <div class="modal-footer">
                          <div class="error_message">{{ bot.msg }}</div>
                          <button type="button" class="btn btn-primary" @click="update_bot(bot)">保存修改</button>
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="refresh_bots">取消</button>
                        </div>
                      </div>
                    </div>
                  </div>

                  <button type="button" class="btn btn-danger" @click="remove_bot(bot)">删除</button>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {ref, reactive} from 'vue';
import {useStore} from "vuex";
import axios from "axios";
// import router from "@/router";
import {Modal} from 'bootstrap/dist/js/bootstrap';
import { VAceEditor } from 'vue3-ace-editor';
// import ace from 'ace-builds';
import "ace-builds/webpack-resolver";
import 'ace-builds/src-noconflict/mode-json';
import 'ace-builds/src-noconflict/theme-chrome';
import 'ace-builds/src-noconflict/ext-language_tools';


export default {
  components: {
    VAceEditor
  },

  setup() {
      const aceConfig = reactive({
        theme: 'xcode', //主题
        arr: [
          /*所有主题*/
          "ambiance",
          "chaos",
          "chrome",
          "clouds",
          "clouds_midnight",
          "cobalt",
          "crimson_editor",
          "dawn",
          "dracula",
          "dreamweaver",
          "eclipse",
          "github",
          "gob",
          "gruvbox",
          "idle_fingers",
          "iplastic",
          "katzenmilch",
          "kr_theme",
          "kuroir",
          "merbivore",
          "merbivore_soft",
          "monokai",
          "mono_industrial",
          "pastel_on_dark",
          "solarized_dark",
          "solarized_light",
          "sqlserver",
          "terminal",
          "textmate",
          "tomorrow",
          "tomorrow_night",
          "tomorrow_night_blue",
          "tomorrow_night_bright",
          "tomorrow_night_eighties",
          "twilight",
          "vibrant_ink",
          "xcode",
        ],
        readOnly: false, //是否只读
        options: {
          enableBasicAutocompletion: true,
          enableSnippets: true,
          enableLiveAutocompletion: true,
          tabSize: 4,
          showPrintMargin: false,
          fontSize: 18
        }
      });


    const store = useStore();
    let bots = ref([]);

    const botadd = reactive({
      title: "",
      description: "",
      content: "",
      msg: "",
    })


    const refresh_bots = () => {
      axios.get('https://app4821.acapp.acwing.com.cn/api/user/bot/getList/', {
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        }
      })
          .then(res => {
            if (res.data.code === 200) {
              bots.value = res.data.userList;
            }
          })
          .catch(() => {

          })
          .then(() => {
            console.log("getBotList")
          });
    }

    refresh_bots();

    const add_bot = () => {
      botadd.msg = "";
      axios.post('https://app4821.acapp.acwing.com.cn/api/user/bot/add/', {
        title: botadd.title,
        description: botadd.description,
        content: botadd.content,
      }, {
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        }
      })
          .then(res => {
            console.log(res)
            if (res.data.code === 200) {
              botadd.title = "";
              botadd.description = "";
              botadd.content = "";
              Modal.getInstance("#add-bot-btn").hide();
              refresh_bots();
            } else {
              botadd.msg = res.data.msg;
            }
          })
          .catch(() => {

          })
          .then(() => {
            console.log("add_bot")
          });
    }

    const remove_bot = (bot) => {
      axios.post('https://app4821.acapp.acwing.com.cn/api/user/bot/remove/', {
        botId: bot.id,
      }, {
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        }
      })
          .then(res => {
            if (res.data.code === 200) {
              refresh_bots();
            }
          })
          .catch(() => {

          })
          .then(() => {
            console.log("remove_bot")
          });
    }


    const update_bot = (bot) => {
      axios.post('https://app4821.acapp.acwing.com.cn/api/user/bot/update/', {
        botId: bot.id,
        title: bot.title,
        description: bot.description,
        content: bot.content,
      }, {
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        }
      })
          .then(res => {
            if (res.data.code === 200) {
              Modal.getInstance('#update-bot-modal-' + bot.id).hide();
              refresh_bots();
            } else {
              bot.msg = res.data.msg;
            }
          })
          .catch(() => {

          })
          .then(() => {
            console.log("update_bot")
          });
    }


    return {
      refresh_bots,
      bots,
      botadd,
      add_bot,
      update_bot,
      remove_bot,
      aceConfig,
    }

  }
}

</script>

<style scoped>
div.error_message {
  color: red;
}
</style>