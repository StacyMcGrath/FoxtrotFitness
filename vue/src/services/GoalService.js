import axios from 'axios';

export default {

  retrievePremadeGoals() {
    return axios.get('/goals/premade')
  },

  retrieveGoalById(goalId) {
    return axios.get(`/goals/${goalId}`)
  },

  retrieveGoalsByUser() {
    return axios.get(`/dashboard/goals`)
  },

  addNewGoal(goal) {
    return axios.post(`/createGoal`, goal)
  }

}