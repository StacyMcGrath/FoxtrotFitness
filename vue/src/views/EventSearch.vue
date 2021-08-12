<template>
<div>
  <div class="listbutton"> 
  <button class="list-toggle" v-on:click="cardView = !cardView">{{cardView ? "View as List" : "View Gallery"}}</button>
  </div>
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
.listbutton {
  text-align: right;
  margin-right: 5%;
}

.list-toggle {
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  margin-left: 2%;
  margin-top: 2%;
  text-align: right;
  border: none; 
  background-color: #e6e6e6;
}

</style>