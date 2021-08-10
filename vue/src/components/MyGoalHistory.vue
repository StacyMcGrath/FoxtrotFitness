<template>
  <div class="goals">
      <img src="..\assets\goal_progress.jpg" alt="Image of Event">
      <h1>My Goal History</h1>
      <ul> 
        <li v-for="goal in goals" v-bind:key="goal.goalId">{{goal.goalName}}</li> 
        
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

img {
    height: 150px;
    width: auto;
}



</style>