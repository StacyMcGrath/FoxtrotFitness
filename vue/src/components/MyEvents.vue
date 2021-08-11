<template>
  <div class="events">
        <span id="myEvents"><i class="fas fa-calendar-check fa-2x"></i>My Events</span>
          
      <ul>
        <!-- <router-link v-on:click="$router.push(`/events/${eventId}`)" >{{event.eventName}}</router-link> -->
        
        <li v-for="event in computedEvents" v-bind:key="event.eventId">
          <a href="#" v-on:click.prevent="viewEventDetails(event.eventId)">{{event.eventName}}</a>
        </li> 
      </ul>
      <button v-on:click="$router.push({name: 'my-event-history'})">View All</button>
  <div>
      <router-link v-bind:to="{name: 'create-event'}" >Create New Event</router-link>
  </div>
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
  viewEventDetails(eventId) {
        this.$router.push(`/events/${eventId}`);
      }  
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

#myEvents {
  font-size: 30px;


}

h1 {
  display: inline;
}

img {
    height: 150px;
    width: auto;
}

/* Events/Goals */

.events {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 15px;
line-height: 18px;
letter-spacing: -0.015em;
}

/* button {
color: #18A0FB;
} */

</style>