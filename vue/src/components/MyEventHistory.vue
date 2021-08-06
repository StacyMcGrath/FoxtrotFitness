<template>
  <div class="events">
      <img src="..\assets\goal_progress.jpg" alt="Image of Event">
      <h1>My Events and Goals</h1>
      <!-- <ul> -->
        <!-- <li v-for="event in events" v-bind:key="event.eventId">{{event.eventName}}</li> -->
        
      <!-- </ul> -->
      <event-card v-for="event in events" v-bind:key="event.eventId" v-bind:event="event" />
  </div>
</template>

<script>
import eventService from '../services/EventService.js'
import EventCard from '../components/EventCard.vue'
export default {
  name: "my-events-history",
  components: {
        EventCard
    },
  data() {
    return {
      events: []
    };

  },
  methods: {

  },
  created() {
    eventService.retrieveEventsByUser().then(response => {
        this.events = response.data;
  }
    )
}
}


</script>

<style scoped>

img {
    height: 150px;
    width: auto;
}

/* Events/Goals */

/* .events {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 15px;
line-height: 18px;
letter-spacing: -0.015em;
}

button {
color: #18A0FB;
} */

</style>