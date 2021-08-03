<template>
  <div>

    <nav>
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

</style>