CourtReservation.destroy_all
User.destroy_all

def date_format(datetime, hour, minute)
  month = datetime.month
  day = datetime.day
  year = datetime.year
  "#{month}/#{day}/#{year} #{hour}:#{minute}:00"
end

def pad(num)
  sprintf("%02d", num)
end

hours = %w(06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21) #%w(6 7 8 9 10 11 12 1 2 3 4 5 6 7 8 9)

now = DateTime.now

user = User.create!(username: 'kmc3',
                    password: 'foobar',
                    first_name: 'Kevin',
                    last_name: 'Chen')

(1..3).to_a.each do |court_number|
  hours.each do |hour|

    minute = court_number==1 ? "00" : (court_number==2 ? "30" : "15")

    date_string = date_format(now, hour, minute)
    
    puts "Creating Court #{court_number} reservation for #{date_string}"
    
    time = Time.zone.parse("#{now.year}-#{pad(now.month)}-#{pad(now.day)} #{hour}:#{minute}:00").utc.in_time_zone('Eastern Time (US & Canada)')

    cr1 = CourtReservation.create!(court_number: court_number, duration_minutes: 60, start_time: time)
    if court_number % 2 == 1
      cr1.users << user
      cr1.save!
    end
    cr2 = CourtReservation.create!(court_number: court_number, duration_minutes: 60, start_time: time + 1.day)

  end
end


user.court_reservations << CourtReservation.all.first
user.save!
