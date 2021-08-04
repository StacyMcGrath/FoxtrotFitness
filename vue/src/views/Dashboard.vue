<template>
<div>
  <activity-form class="form"/>
  <div class="dashboard">
    <my-events class="events"/>
    <my-activities class="activities"/>
    <my-badges class="badges"/>
  </div>
</div>  
</template>

<script>
import ActivityForm from '../components/ActivityForm.vue'
import MyActivities from '../components/MyActivities.vue'
import MyBadges from '../components/MyBadges.vue'
import MyEvents from '../components/MyEvents.vue'

export default {
  components: { MyEvents, ActivityForm, MyActivities, MyBadges },

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
.badges {
  grid-area: badges;
}
.dashboard {
display: grid;
justify-items: center;
grid-template-columns: 1fr 1fr 1fr;
grid-template-areas: 
"events activities badges";

}

</style>