<template>
<div class="container-fluid">
  <div class="container">    
        <h2>My Goal History </h2>
        <ul class="responsive-table">
          <li class="table-header">
            <div class="col col-1">Goal</div>
            <div class="col col-2">Activity Type(s)</div>
            <div class="col col-3">Activity Goal</div>
            <div class="col col-4">Date Range</div>
          </li>
          <li class="table-row" v-for="goal in goals" v-bind:key="goal.goalId">
            <div class="col col-1" data-label="Goal">{{goal.goalName}}</div>
            <div class="col col-2" data-label="Activity Type">
              <p id="activity" v-for="activity in goal.activityType" v-bind:key="activity">{{activity}}</p>
            </div>
            <div class="col col-3" data-label="Activity Goal">{{goal.activityGoal}} {{goal.activityUnits}}</div>
            <div class="col col-4" data-label="Date Range">{{goal.startDate | formatDate}} - {{goal.endDate | formatDate}}</div>
          </li>
        </ul>  
  </div>
  </div>
</template>

<script>
import goalService from '../services/GoalService.js'
export default {
  name: "my-goal-history",
 
  data() {
    return {
      goals: []
    };

  },
  methods: {

  },
  created() {
    goalService.retrieveGoalsByUser().then(response => {
        this.goals = response.data;
  }
    )
}
}


</script>

<style scoped>

 .container-fluid {
    color: rgb(99, 86, 86);
    overflow-x: hidden;
    height: 100%;
    background-image: url("../assets/Home Page Graphic.jpg");
    background-repeat: no-repeat;
    background-size: 100% auto;
} 

body {
  font-family: 'Montserrat', sans-serif;
}

.container {
  background-color: #e6e6e6;
  max-width: 70%;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
  /* margin-bottom: 30px; */
  padding-bottom: 30px;
}

h2 {
  font-size: 26px;
  margin: 20px 30px;
  padding-top: 30px;
  text-align: center;
  
}
  li {
    border-radius: 3px;
    padding: 10px 30px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 25px;
    margin-right: 30px;
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
  }
  .table-row:nth-child(even) {
  background: #edf0db;
  }
  .table-row:nth-child(odd) {
    background: #cfe6e0;
    
  }
  .col-1 {
    flex-basis: 27%;
  }
  .col-2 {
    flex-basis: 22.5%;
  }
  .col-3 {
    flex-basis: 22.5%;
  }
  .col-4 {
    flex-basis: 28%;
  }

  
  

</style>