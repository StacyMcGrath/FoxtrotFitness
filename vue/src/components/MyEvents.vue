<template>
  <div class="events">
      <img src="..\assets\MyEvents.png">
        <!-- <span id="myEvents"><i class="fas fa-calendar-check" style="color: #505170"></i> My Events</span> -->
          
      <ul>
        <!-- <router-link v-on:click="$router.push(`/events/${eventId}`)" >{{event.eventName}}</router-link> -->
        
        <li v-for="event in computedEvents" v-bind:key="event.eventId">
          <a href="#" v-on:click.prevent="viewEventDetails(event.eventId)">{{event.eventName}}</a>
        </li> 
      </ul>
      <router-link id="viewall" v-bind:to="{name: 'my-event-history'}">View All</router-link>
  <div>
      <button v-on:click="$router.push({name: 'create-event'})" >Create New Event</button>
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

.events {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 20px;
line-height: 18px;
letter-spacing: -0.015em;
width: 100%;
margin-left: 15%;
}


#viewall {
  font-size: 12px;
  margin-left: 35%;
  
}


ul {
   margin-left: 10%;
  line-height: 200%;
}


img {
    width: 80%;
    height: auto;
}

/* Events/Goals */

events {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 20px;
line-height: 18px;
letter-spacing: -0.015em;
}

button {
  background-color: #f16120;
  font-family: 'Montserrat', sans-serif;
  border: none;
  color: #edf0db;
  text-align: center;
  width: 50%;
  height: 25px;
  margin-top: 3%;
  margin-left: 18%;
  margin-bottom: 10%;
  font-size: 15px;
  border-radius: 8px;
}

</style>