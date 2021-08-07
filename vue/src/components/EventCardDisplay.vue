<template>
    <div class="card-display">
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