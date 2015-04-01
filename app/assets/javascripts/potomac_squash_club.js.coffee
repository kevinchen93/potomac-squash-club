window.PotomacSquashClub =
  Models: {}
  Collections: {}
  Views: {}
  Routers: {}
  initialize: ->
    alert 'Hello from Backbone!'

window.App = window.PotomacSquashClub

$(document).ready ->
  PotomacSquashClub.initialize()
