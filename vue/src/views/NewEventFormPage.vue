<template>
<div>
  <new-event-form/>
  <test-new-event-form/>
</div>
</template>

<script>
import NewEventForm from '../components/NewEventForm.vue'
import TestNewEventForm from '../components/TestNewEventForm.vue'

export default {
  components: { NewEventForm, TestNewEventForm },

}
</script>

<style>
    

</style>