class CourtReservation < ActiveRecord::Base
  has_and_belongs_to_many :users
  
  validates :court_number, presence: true
  validates :start_time, presence: true
  
end
