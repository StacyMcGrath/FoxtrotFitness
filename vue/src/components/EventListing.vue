<template>
  <div>
    <table class="minimalistBlack">
      <thead>
        <tr>
        <th>Event Name</th>
        <th>Activity Type</th>
        <th>Total Event Miles</th>
        <th>Individual Member Miles</th>
        <th>Dates</th>
        </tr>
      </thead>
      <tbody>
        <tr>
        <td>
          <input type="text" name="eventName" v-model="eventFilter">
        </td>
        <td>
          <div id="v-model-select">
            <select v-model="activityFilter">
            <option disabled value="">Please select one</option>
              <option></option>
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
        <td>&nbsp;</td>
        </tr>
        <tr v-for="event in filteredEvents" v-bind:key="event.eventId">
        <td>{{event.eventName}}</td>
        <td>
          <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>
        </td>
        <td>{{event.totalActivityGoal}}</td>
        <td>{{event.userActivityGoal}}</td>
        <td>{{event.startDate}} - {{event.endDate}}</td>
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
        events: [],
      };
    },
    computed: {
      filteredEvents() {
        let filteredEvents = this.events;
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
    }
}
</script>

<style>
table.minimalistBlack {
  border: 3px solid #000000;
  width: 100%;
  text-align: left;
  border-collapse: collapse;
}
table.minimalistBlack td, table.minimalistBlack th {
  border: 1px solid #000000;
  padding: 5px 4px;
}
table.minimalistBlack tbody td {
  font-size: 13px;
}
table.minimalistBlack thead {
  background: #CFCFCF;
  background: -moz-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: -webkit-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: linear-gradient(to bottom, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  border-bottom: 3px solid #000000;
}
table.minimalistBlack thead th {
  font-size: 15px;
  font-weight: bold;
  color: #000000;
  text-align: left;
}

</style>