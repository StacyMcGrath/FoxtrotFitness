<template>
  <div>

    <nav>
        <img src="..\assets\Orange Fox Animal Logo.png" alt="">
        <router-link v-bind:to="{name: 'home'}">Home</router-link> | 
        <router-link v-bind:to="{name: 'events'}">Events</router-link> | 
        <router-link v-bind:to="{name: 'dashboard'}">Dashboard</router-link>
    </nav>


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
  height: 100px;
  width: auto;
}

</style>