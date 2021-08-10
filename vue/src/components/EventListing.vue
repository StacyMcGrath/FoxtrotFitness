<template>
  <div>
    <table class="event-list">
      <thead>
        <tr>
        <th>Event Name</th>
        <th>Activity Type</th>
        <th>Individual Goal</th>
        <th>Event Community Goal</th>
        <th>Dates</th>
        </tr>
      </thead>
      <tbody>
        <tr class="filter-row">
        <td>
          <input type="text" name="eventName" placeholder="Search Event Name" v-model="eventFilter">
        </td>
        <td>
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
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>
          <button v-on:click="togglePastEvents">{{endDateFilter!='' ? "Show Past Events" : "Hide Past Events"}}</button>
        </td>
        </tr>
        <tr class="event-rows" v-on:click="viewEventDetails(event.eventId)" v-for="event in filteredEvents" v-bind:key="event.eventId">
        <td id="eventname">{{event.eventName}}</td>
        <td>
          <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>
        </td>
        <td v-if="event.userActivityGoal>0">{{event.userActivityGoal.toLocaleString()}}</td>
        <td v-else>Whatever you can do!</td>
        <td v-if="event.totalActivityGoal>0">{{event.totalActivityGoal.toLocaleString()}}</td>
        <td v-else>N/A</td>
        <td>{{event.startDate | formatDate}} - {{event.endDate | formatDate}}</td>
        </tr>
      </tbody>
    </table>  
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
template {
  background-color: #edf0db;
}

.event-list-view{
  background-color: #edf0db;
}
table.event-list {
  font-family: 'Montserat', sans-serif;
  color: #505170;
  background-color: #edf0db;
  border-collapse: collapse;
  border: 1px solid #505170;
  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 10%;
  margin-right: 10%;
  width: auto;
}
td:nth-child(1) {
  width: 30%;
}
td:nth-child(2) {
  width: 20%;
}
td:nth-child(3) {
  width: 15%;
}
 td:nth-child(4) {
  width: 15%;
}
td:nth-child(5) {
  width: 20%;
}
tr:nth-child(even) {
  background: #edf0db;
}
tr:nth-child(odd) {
  background: #cfe6e0;
}
tr:nth-child(1) {
  background: #74769D;
}
table.event-list td, table.event-list th {
  border-bottom: 0.5px solid #505170;
  padding: 5px 4px;
  text-align: center;
}
#eventname, th.eventname {
  text-align: left;
}

table.event-list tbody td {
  font-size: 13px;
}
table.m.event-list thead {
  background: #edf0db;
  
}
table.event-list thead th {
  font-size: 15px;
  height: 50px;
  font-weight: bold;
  color: #edf0db;
  text-align: center;
  background-color: #74769D;
}
#activity {
  line-height: normal;
}
select, input {
  background-color: #f6f7ed;
}
button {
  background-color: #f6f7ed;
}


</style>