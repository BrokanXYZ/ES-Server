from twilio.rest import Client

account_sid = "AC1e4df4f5e45ace919942eeca01d78758"
auth_token = "61ddc9548d6acd480daa7c389382222f"

client = Client(account_sid, auth_token)

client.api.account.messages.create(
    to="+15015172074",
    from_="+15017125874",
    body="Hello there!")
