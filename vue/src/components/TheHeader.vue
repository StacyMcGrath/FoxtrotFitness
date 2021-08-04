<template>
  <div>

    <nav>
      <img src="..\assets\Orange Fox Animal Logo.png" alt="">
      <ul>
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
  padding: 14px 16px;
  background-color: #dddddd;
  text-align: center;
  text-decoration: none;
}
.register{
  float:right;
  display: block;
  padding: 14px 16px;
  background-color: coral;
  text-align: center;
  text-decoration: none;
}
.navbutton:hover {
  background-color: white;
}

.register:hover {
  background-color: white;
}



</style>