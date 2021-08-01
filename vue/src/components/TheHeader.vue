<template>
  <div>
      <h1>FoxTrot Fitness Tracker</h1>
      <nav>
          <router-link v-bind:to="{name: 'home'}">Home</router-link> | 
          <router-link v-bind:to="{name: 'events'}">Events</router-link> | 
          <a href="#">About</a>

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

<style>

</style>