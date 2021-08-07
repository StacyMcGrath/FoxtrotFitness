<template>
<div>
  <button class="list-toggle" v-on:click="cardView = !cardView">{{cardView ? "View as List" : "View as Cards"}}</button>
  <div v-show="!cardView"><event-listing /></div>
  <div v-show="cardView"><event-card-display /></div>
</div>
</template>

<script>
import EventCardDisplay from '../components/EventCardDisplay.vue';
import EventListing from '../components/EventListing.vue';
export default {
  data (){ return {
    cardView: true
  }
  },
  
  components: { 
      EventListing,
    EventCardDisplay },

}
</script>

<style scoped>

.list-toggle {
  margin-left: 5%;
  margin-top: 2%;
  text-align: center;
}
</style>>