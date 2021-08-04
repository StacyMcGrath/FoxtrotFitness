<template>
  <div>

    <nav>
      <ul>
        <li><img src="..\assets\Fox logo.png" alt=""></li>
        <li><router-link class="navbutton" v-bind:to="{name: 'home'}">Home</router-link></li>
        <li><router-link class="navbutton" v-bind:to="{name: 'events'}">Events</router-link></li>
        <li><router-link class="navbutton" v-bind:to="{name: 'dashboard'}" v-if="$store.state.token != ''">Dashboard</router-link></li>
        <li2><router-link  class="register" v-bind:to="{name: 'login'}" v-if="$store.state.token == ''">Login</router-link></li2>
        <li2><router-link  class="register" v-bind:to="{name: 'logout'}" v-if="$store.state.token != ''">Logout</router-link></li2>    
        <li2><router-link class="register" v-bind:to="{name: 'register'}" v-show="$store.state.token == ''">Register</router-link></li2>
        <li3 v-if="$store.state.token != ''">Welcome, User!</li3>
     </ul>
    </nav>


  <!-- <nav>
    <div class="nav-wrapper">
      <img src="..\assets\Orange Fox Animal Logo.png" alt="">
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><router-link v-bind:to="{name: 'home'}">Home</router-link> </li>
        <li><router-link v-bind:to="{name: 'events'}">Events</router-link></li>
        <li><router-link v-bind:to="{name: 'dashboard'}">Dashboard</router-link></li>
      </ul>
    </div>
  </nav> -->
        


  </div>
</template>

<script>

export default {
    name: 'the-header',
    data() {
        return {
          
        }
    },
    computed: {
      displayName() {
        const displayName = this.$store.state.user;
        return displayName;
      }
    }
}
</script>

<style scoped>
img {
  height: 50px;
  width: auto;
  margin-right: 20px;
}

ul {
  height: 50px;
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #dddddd;
}
li{
  float: left;
  text-decoration: none;
}
li2{
  float: right;
  text-decoration: none;
}
li3{
  float: right;
  padding: 13px;
  text-decoration: none;
}
 .navbutton {
  display: block;
  padding: 14px 16px;
  height: 50px;
  background-color: #dddddd;
  text-align: center;
  text-decoration: none;
  font-family: Arial;
  color: darkslategray;
}
.register{
  float:right;
  display: block;
  height: 50px;
  padding: 14px 16px;
  background-color: #f16120;
  text-align: center;
  text-decoration: none;
  color: white;
  font-family: Arial;
}
.navbutton:hover {
  height: 50px;
  background-color: white;
}

.register:hover {
  height: 50px;
  background-color: white;
  color:black;

}



</style>