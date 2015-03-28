# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

def date_format(datetime, hour, minute)
  month = datetime.month
  day = datetime.day
  year = datetime.year
  "#{month} #{day} #{year} #{hour}:#{minute}:00"
end

hours = %w(06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21) #%w(6 7 8 9 10 11 12 1 2 3 4 5 6 7 8 9)

now = DateTime.now

(1..3).to_a.each do |court_number|
  hours.each do |hour|

    minute = court_number==1 ? "00" : (court_number==2 ? "30" : "15")

    date_string = date_format(now, hour, minute)
    
    puts "Creating Court #{court_number} reservation for #{date_string}"

    court_res = CourtReservation.new(court_number: court_number,
                                     duration_minutes: 60,
                                     start_time: date_string)
    court_res.save!
  end
end

user = User.create!(username: 'kmc3',
                    password: 'foobar',
                    first_name: 'Kevin',
                    last_name: 'Chen')
user.court_reservations << CourtReservation.find(1)
user.save!
