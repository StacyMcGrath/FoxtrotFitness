<template>
<div>
  <activity-form class="form"/>
  <div class="dashboard">
    <my-events class="events"/>
    <my-activities class="activities"/>
    <my-goals class="goals"/>
  </div>
</div>  
</template>

<script>
import ActivityForm from '../components/ActivityForm.vue'
import MyActivities from '../components/MyActivities.vue'
import MyGoals from '../components/MyGoals.vue'
import MyEvents from '../components/MyEvents.vue'

export default {
  components: { MyEvents, ActivityForm, MyActivities, MyGoals },

}
</script>

<style scoped>

.form {
  grid-area: form;
  
}
.events {
  grid-area: events;
}
.activities {
  grid-area: activities;
}
.goals {
  grid-area: goals;
}
.dashboard {
display: grid;
justify-items: center;
grid-template-columns: 1fr 1fr 1fr;
grid-template-areas: 
"events goals activities";

}

</style>