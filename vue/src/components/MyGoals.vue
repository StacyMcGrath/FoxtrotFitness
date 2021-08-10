<template>
  <div class="goals">
      <img src="..\assets\goal_progress.jpg" alt="Image of Event">
      <h1>My Goals</h1>
      <ul>
        <!-- <router-link v-on:click="$router.push(`/events/${eventId}`)" >{{event.eventName}}</router-link> -->
        
        <li v-for="goal in computedGoals" v-bind:key="goal.userId">{{goal.goalName}}</li> 
      </ul>
      <button v-on:click="$router.push({name: 'my-goal-history'})">View All</button>
  <div>
      <router-link v-bind:to="{name: 'create-goal'}" >Create New Goal</router-link>
  </div>

  </div>
</template>

<script>
import goalService from '../services/GoalService.js'
export default {
  name: "my-goals",
  data() {
    return {
      goals: [],
      limit: 3
      
    };

  },
  computed: {
    computedGoals() {
      return this.limit ? this.goals.slice(0, this.limit) : this.goals
    }

  },
  methods: {
  viewGoalDetails() {
        this.$router.push(`/myGoals`);
      }  
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

/* Events/Goals */

/* .events {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 15px;
line-height: 18px;
letter-spacing: -0.015em;
}

button {
color: #18A0FB;
} */

</style>