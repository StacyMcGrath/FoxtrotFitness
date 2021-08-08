<template>
    <div class="card-display">
      <input type="text" name="eventName" placeholder="Search Event Name" v-model="eventFilter">
      <div class="input-field col s12">
            <select v-model="activityFilter">
            <option disabled value="">Filter by Activity</option>
              <option value="">View All</option>
              <option>Running</option>
              <option>Walking</option>
              <option>Swimming</option>
              <option>Cycling</option>
              <option>Other</option>
            </select>
          </div>
      <button v-on:click="togglePastEvents">{{endDateFilter!='' ? "Show Past Events" : "Hide Past Events"}}</button>
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
  margin: 4%;
}
</style>