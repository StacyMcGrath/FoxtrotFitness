<template>
  <div>
    <activity-form />
    <my-events />
  </div>
</template>

<script>
import ActivityForm from '../components/ActivityForm.vue'
import MyEvents from '../components/MyEvents.vue'

export default {
  components: { MyEvents, ActivityForm },

}
</script>

<style>

</style>