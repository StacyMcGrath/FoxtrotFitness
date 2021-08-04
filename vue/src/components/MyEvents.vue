<template>
  <div class="events">
      <img src="..\assets\goal_progress.jpg" alt="Image of Event">
      <h1>My Events and Goals</h1>
      <ul>
        <li v-for="event in computedEvents" v-bind:key="event.eventId">{{event.eventName}}</li>
      </ul>
      <button>View All</button>
  </div>
</template>

<script>
import eventService from '../services/EventService.js'
export default {
  name: "my-events",
  data() {
    return {
      events: [],
      limit: 3
      
    };

  },
  computed: {
    computedEvents() {
      return this.limit ? this.events.slice(0, this.limit) : this.events
    }

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