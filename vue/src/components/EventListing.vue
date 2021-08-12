<template>
  <div class="container">
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

      <ul class="responsive-table">
          <li class="table-header">
            <div class="col col-1">Event Name</div>
            <div class="col col-2">Activity Type(s)</div>
            <div class="col col-3">Individual Goal</div>
            <div class="col col-4">Community Goal</div>
            <div class="col col-5">Dates</div>
          </li>

          <li class="table-row" v-on:click="viewEventDetails(event.eventId)" v-for="event in filteredEvents" v-bind:key="event.eventId">
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
export default {
    name: 'event-listing',
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
      }
    }
}
</script>

<style scoped>

body {
  font-family: 'Montserrat', sans-serif;
}
.container {

  margin-left: 5%;
  margin-right: 5%;

}
.event-filters {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  column-gap: 2rem;
  grid-template-areas: "namefilter activityfilter  . pastevents";
  margin: 0% 0% 1% 3%;
 
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
  select, input {
  background-color: #f6f7ed;
}
button {
  background-color: #f6f7ed;
}
  


</style>