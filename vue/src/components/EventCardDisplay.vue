<template>
    <div class="card-display">
      <div class="event-filters">
      <input type="text" id ="event-name-filter" name="eventName" placeholder="Search Event Name" v-model="eventFilter">
            <select id="activity-type-filter" v-model="activityFilter">
            <option disabled value="">Filter by Activity</option>
              <option value="">View All</option>
              <option>Running</option>
              <option>Walking</option>
              <option>Swimming</option>
              <option>Cycling</option>
              <option>Other</option>
            </select>
      <button class="past-events" v-on:click="togglePastEvents">{{endDateFilter!='' ? "Show Past Events" : "Hide Past Events"}}</button>
      </div>
      <div class="row">
        <event-card v-for="event in filteredEvents" v-bind:key="event.eventId" v-bind:event="event" />
      </div>
    </div>
</template>

<script>
import EventCard from '../components/EventCard.vue'
import eventService from '../services/EventService.js'
export default {

    name: 'event-card-display',
    components: {
        EventCard
    },
    data() {
      return{
        activityFilter: '',
        eventFilter: '',
        endDateFilter: Date.now(),
        events: [],
      };
    },
    computed: {
      filteredEvents() {
        let filteredEvents = this.events;
        if(this.endDateFilter != '') {
          filteredEvents = filteredEvents.filter((event) => 
          new Date(event.endDate) >= this.endDateFilter
          );
        }
        if(this.activityFilter != '') {
        filteredEvents = filteredEvents.filter( (event) => 
          event.activityType.includes(this.activityFilter)
        );
      } 
      if(this.eventFilter != '') {
        filteredEvents = filteredEvents.filter((event) => 
          event.eventName.toLowerCase().includes(this.eventFilter.toLowerCase())
        );
      }
      return filteredEvents;
    }
  
    },
    created() {
      eventService.retrieveEvents().then(response => {
        this.events = response.data;
      })
    },
    methods: {
      viewEventDetails(eventId) {
        this.$router.push(`/events/${eventId}`);
      },
      togglePastEvents() {
        if(this.endDateFilter!='') {
          this.endDateFilter = '';
        } else {
          this.endDateFilter = Date.now();
        }
      },
    }
}



</script>

<style>
.card-display {
  margin: 5%;
  margin-top: 0%;
}

.event-filters {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  column-gap: 2rem;
  grid-template-areas: "namefilter activityfilter  . pastevents";
  margin: 0% 0% 2% 1%;
 
}

#event-name-filter {
  grid-area: namefilter;
  background-color: #edf0db;
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  border: solid #505170 1px;
  border-radius: 5px;
  
}

#activity-type-filter {
  grid-area: activityfilter;
  background-color: #edf0db;
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  border: solid #505170 1px;
  border-radius: 5px;
}

.past-events {
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  margin-left: 2%;
  margin-top: 2%;
  text-align: right;
  border: none; 
  background-color: #e6e6e6;
  grid-area: pastevents;
  font-size: 14px;

}
</style>