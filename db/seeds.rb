# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

hours = %w(6 7 8 9 10 11 12 1 2 3 4 5 6 7 8 9)
today = Time.now.strftime '%Y-%m-%d'

(1..3).to_a.each do |court_number|
  hours.each do |hour|
    minute = court_number==1 ? "00" : (court_number==2 ? "30" : "15")
    start_time = hour + ":" + minute
    CourtReservation.create!(court_number: court_number,
                             start_time: start_time,
                             date: today)
  end
end

user = User.create!(username: 'kmc3',
                    password: 'foobar',
                    first_name: 'Kevin',
                    last_name: 'Chen')
user.court_reservations << CourtReservation.find(1)
user.save
