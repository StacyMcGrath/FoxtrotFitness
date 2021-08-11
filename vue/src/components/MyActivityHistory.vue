<template>
  <div class="container">
      
        <h2>My Activity History </h2>
        <ul class="responsive-table">
          <li class="table-header">
            <div class="col col-1">Date</div>
            <div class="col col-2">Activity Type</div>
            <div class="col col-3">Distance (Miles)</div>
            <div class="col col-4">Time (Minutes)</div>
          </li>
          <li class="table-row" v-for="activity in activities" v-bind:key="activity.activityId">
            <div class="col col-1" data-label="Date">{{activity.activityDate | formatDate}}</div>
            <div class="col col-2" data-label="Activity Type">{{activity.activityType}}</div>
            <div class="col col-3" data-label="Distance">{{activity.distance}}</div>
            <div class="col col-4" data-label="Time">{{activity.numberOfMinutes}}</div>
          </li>
        </ul> 
      
  </div>
</template>

<script>
import activityService from '../services/ActivityService.js'
export default {
  name: "my-activity-history",
  data() {
    return {
      activities: []
      
    };

  },
  methods: {

  },
  created() {
    activityService.retrieveActivitiesByUser().then(response => {
        this.activities = response.data;
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
  max-width: 70%;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
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
  }
  .table-row:nth-child(even) {
  background: #edf0db;
  }
  .table-row:nth-child(odd) {
    background: #cfe6e0;
    
  }
  .col-1 {
    flex-basis: 25%;
  }
  .col-2 {
    flex-basis: 25%;
  }
  .col-3 {
    flex-basis: 25%;
  }
  .col-4 {
    flex-basis: 25%;
  }

  

</style>