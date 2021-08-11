<template>
  <div class="events">
      <img src="..\assets\My Events.png">
        <!-- <span id="myEvents"><i class="fas fa-calendar-check" style="color: #505170"></i> My Events</span> -->
          
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

#myEvents {
  font-size: 40px;
  font-weight: bold;
  border-radius: 50%;
  padding: 2% 10%;
  margin: 5px;
  color: #505170;
  text-shadow: 2px 2px gray; 
  box-shadow: 3px 3px gray;
  background-image: linear-gradient(to right, #020024, #b6d44a)



}
ul {
  margin-top: 5%;
  line-height: 200%;
}


img {
    width: 80%;
    height: auto;
}

/* Events/Goals */



/* button {
color: #18A0FB;
} */

</style>