<template>
  <div>
      <img src="" alt="Image of Event">
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

<style>

</style>