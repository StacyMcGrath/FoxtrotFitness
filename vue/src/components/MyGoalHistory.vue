<template>
  <div class="container">
      <!-- <img src="..\assets\goal_progress.jpg" alt="Image of Event">
      <h1>My Goal History</h1>
      <ul> 
        <li v-for="goal in goals" v-bind:key="goal.goalId">{{goal.goalName}}</li> 
        
      </ul> -->
            <h2>Responsive Tables Using LI <small>Triggers on 767px</small></h2>
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

body {
  font-family: 'lato', sans-serif;
}
.container {
  max-width: 1000px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
}

h2 {
  font-size: 26px;
  margin: 20px 0;
  text-align: center;
  small {
    font-size: 0.5em;
  }
}

.responsive-table {
  li {
    border-radius: 3px;
    padding: 25px 30px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 25px;
  }
  .table-header {
    background-color: #95A5A6;
    font-size: 14px;
    text-transform: uppercase;
    letter-spacing: 0.03em;
  }
  .table-row {
    background-color: #ffffff;
    box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
  }
  .col-1 {
    flex-basis: 15%;
  }
  .col-2 {
    flex-basis: 35%;
  }
  .col-3 {
    flex-basis: 25%;
  }
  .col-4 {
    flex-basis: 25%;
  }
  
  @media all and (max-width: 767px) {
    .table-header {
      display: none;
    }
    .table-row{
      
    }
    li {
      display: block;
    }
    .col {
      
      flex-basis: 100%;
      
    }
    .col {
      display: flex;
      padding: 10px 0;
      &:before {
        color: #6C7A89;
        padding-right: 10px;
        content: attr(data-label);
        flex-basis: 50%;
        text-align: right;
      }
    }
  }
}



</style>