<template>
  <div>

    <nav>
      <ul>
        <li><img src="..\assets\Fox logo.png" alt=""></li>
        <li><router-link class="navbutton" v-bind:to="{name: 'home'}">Home</router-link></li>
        <li><router-link class="navbutton" v-bind:to="{name: 'events'}">Events</router-link></li>
        <li><router-link class="navbutton" v-bind:to="{name: 'dashboard'}">Dashboard</router-link></li>
        <li class="register">Register</li>
        <li class="register">Login</li>
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

}

 .navbutton {
  display: block;
  padding: 12px 16px;
  background-color: #dddddd;
  text-align: center;
  text-decoration: none;
  font-family: Arial;
  color: darkslategray;
}
.register{
  float:right;
  display: block;
  padding: 12px 16px;
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