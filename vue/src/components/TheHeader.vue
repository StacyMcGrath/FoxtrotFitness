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
        <li3 v-if="$store.state.token != ''">Welcome!</li3>
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
  margin-left: 20px;
  margin-right: 20px;
}

ul {
  height: 50px;
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #cfe6e0;
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
  font-family: 'Montserrat', sans-serif;
  text-decoration: none;
  color: #505170
}
 .navbutton {
  display: block;
  padding: 14px 16px;
  height: 50px;
  background-color:  #cfe6e0;
  text-align: center;
  text-decoration: none;
  font-weight: bold;
  
  font-family: 'Montserrat', sans-serif;
  color: #505170
}
.register{
  float:right;
  display: block;
  height: 50px;
  padding: 14px 16px;
  background-color: #f16120;
  text-align: center;
  text-decoration: none;
  font-weight: bold;
  color: #edf0db;
  font-family: 'Montserrat', sans-serif;
}
.navbutton:hover {
  height: 50px;
  background-color:#edf0db
}

.register:hover {
  height: 50px;
  background-color: #edf0db;
  color: #505170;

}



</style>