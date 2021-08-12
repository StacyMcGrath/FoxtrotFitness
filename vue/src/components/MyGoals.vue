<template>
  <div class="goals">
      <img src="..\assets\MyGoals.png" alt="Image of Event">
      
      <ul>
        <!-- <router-link v-on:click="$router.push(`/events/${eventId}`)" >{{event.eventName}}</router-link> -->
        
        <li v-for="goal in computedGoals" v-bind:key="goal.userId">{{goal.goalName}}</li> 
      </ul>
      <router-link id="viewall" v-bind:to="{name: 'my-goal-history'}">View All</router-link>
  <div>
    <button v-on:click="$router.push({name: 'create=goal'})">Create New Goal</button>
     
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
    width: 80%;
    height: auto;
}


#viewall {
  font-size: 12px;
  margin-left: 35%;
  
}
ul {
   margin-left: 5%;
  line-height: 200%;
}


.goals {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 20px;
line-height: 18px;
letter-spacing: -0.015em;
width: 100%;
margin-left: 15%;
}

button {
  background-color: #f16120;
  font-family: 'Montserrat', sans-serif;
  border: none;
  color: #edf0db;
  text-align: center;
  width: 50%;
  height: 25px;
  margin-top: 3%;
  margin-left: 20%;
  margin-bottom: 10%;
  font-size: 15px;
  border-radius: 10px;
} 

</style>