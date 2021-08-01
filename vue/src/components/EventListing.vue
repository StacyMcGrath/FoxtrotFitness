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
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        <tr v-for="event in filteredEvents" v-bind:key="event.eventId">
        <td>{{event.eventName}}</td>
        <td>
          <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>
        </td>
        <td>{{event.totalGoal}}</td>
        <td>{{event.userGoal}}</td>
        <td>{{event.startDate}} - {{event.endDate}}</td>
        </tr>
      </tbody>
    </table> 
  </div>
</template>

<script>
export default {
    name: 'event-listing',
    data() {
      return{
        activityFilter: '',
        events: [],
      };
    },
    computed: {
      filteredEvents() {
        const events = this.$store.state.events;

        return events.filter( (event) => {
          return this.activityFilter == '' ? true : this.activityFilter == event.activityType;
        })
      }
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