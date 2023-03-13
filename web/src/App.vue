<template>

  <NavBar/>
  <router-view></router-view>
</template>


<script>
import NavBar from './components/NavBar'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"

export default {
  components: {
    NavBar
  }

}
</script>

<style>
body {
  background-image: url("@/assets/images/gradual.png");
  /*background-color: black;*/
  background-size: cover;
  background-repeat: no-repeat;
}
</style>
