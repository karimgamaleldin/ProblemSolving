class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        hashset = set()
        for email in emails:
            email = self.process_email(email)
            hashset.add(email)
        return len(hashset)
    
    def process_email(self, email: str) -> str:
        local, domain = email.split('@')
        local_plus = local.split('+')[0].replace('.', '')
        return f'{local_plus}@{domain}'
        