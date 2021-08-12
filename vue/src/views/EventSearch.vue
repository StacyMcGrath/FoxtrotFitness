<template>
<div>
  <h1>Virtual Events</h1>
  <p id="events-text">When you join a virtual event, your effort helps the event community reach a cooperative 
    goal. Working toward a community goal will motivate you to keep moving, and in the process, you'll also 
    crush your personal goals!<br><br>Sign up for an event to see the progress and leaderboard, then get moving to climb up the ranks.</p>
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

#events-text{
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  margin: 2% 6% 0% 6%;
  font-size: 18px;
}

h1 {
  margin-left: 6%;
  margin-top: 2%;
    font-family: 'Montserrat', sans-serif;
    color: #505170;
    font-weight: bold;
}

</style>