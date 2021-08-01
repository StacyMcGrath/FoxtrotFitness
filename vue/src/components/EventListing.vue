<template>
  <div>
    <table>
<tbody>
<tr>
<th>Event Name</th>
<th>Activity Type</th>
<th>Total Event Miles</th>
<th>Individual Member Miles</th>
<th>Dates</th>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr v-for="event in filteredEvents" v-bind:key="event.eventId">
<td>{{event.eventName}}</td>
<td>{{event.activityType}}</td>
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

</style>