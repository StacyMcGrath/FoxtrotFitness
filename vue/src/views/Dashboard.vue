<template>
  <div>
    <activity-form />
    <my-events />
    <my-activities />
    <my-badges />
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

<style>

</style>