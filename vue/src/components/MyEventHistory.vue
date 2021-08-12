<template>
  <div class="container">
      
      <h2>My Events</h2>
      <!-- <ul> -->
        <!-- <li v-for="event in events" v-bind:key="event.eventId">{{event.eventName}}</li> -->
        
      <!-- </ul> -->
      <!-- <event-card v-for="event in events" v-bind:key="event.eventId" v-bind:event="event" /> -->
      <ul class="responsive-table">
          <li class="table-header">
            <div class="col col-1">Event Name</div>
            <div class="col col-2">Activity Type(s)</div>
            <div class="col col-3">Individual Goal</div>
            <div class="col col-4">Community Goal</div>
            <div class="col col-5">Dates</div>
          </li>

          <li class="table-row" v-on:click="viewEventDetails(event.eventId)" v-for="event in events" v-bind:key="event.eventId">
            <div class="col col-1" data-label="Event Name">{{event.eventName}}</div>
            <div class="col col-2" data-label="Activity Type">
              <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>
            </div>
            <div class="col col-3" data-label="Individual Goal">
              <p v-if="event.userActivityGoal>0">{{event.userActivityGoal.toLocaleString()}}</p>
              <p v-else>Whatever you can do!</p>
            </div>
            <div class="col col-4" data-label="Event Community Goal">
              <p v-if="event.totalActivityGoal>0">{{event.totalActivityGoal.toLocaleString()}}</p>
              <p v-else>N/A</p>
            </div>
            <div class="col col-5" data-label="Dates">{{event.startDate | formatDate}} - {{event.endDate | formatDate}}</div>
          </li>
      </ul>
  

  </div>
</template>

<script>
import eventService from '../services/EventService.js'
// import EventCard from '../components/EventCard.vue'
export default {
  name: "my-events-history",
  components: {
    
    },
  data() {
    return {
      events: []
    };

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
body {
  font-family: 'Montserrat', sans-serif;
}
.container {
  max-width: 80%;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
  font-family: 'Montserrat', sans-serif;
}

h2 {
  font-size: 26px;
  margin: 20px 0;
  text-align: center;
  
}


  li {
    border-radius: 3px;
    padding: 10px 30px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 25px;
    vertical-align: middle;
  }
  .table-header {
  background-color: #e6e6e6;
    font-size: 14px;
    text-transform: uppercase;
    letter-spacing: 0.03em;
    font-weight: bold;
    vertical-align: bottom;
    margin-bottom: 0%;
  }
  .table-row {
    background-color: #ffffff;
    box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
    vertical-align: middle;
  }
  .table-row:nth-child(even) {
  background: #edf0db;
  }
  .table-row:nth-child(odd) {
    background: #cfe6e0;
    
  }
  .col-1 {
    flex-basis: 20%;
  }
  .col-2 {
    flex-basis: 20%;
  }
  .col-3 {
    flex-basis: 20%;
  }
  .col-4 {
    flex-basis: 20%;
  }

  .col-5 {
    flex-basis: 20%;
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